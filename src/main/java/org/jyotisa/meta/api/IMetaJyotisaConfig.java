package org.jyotisa.meta.api;

import org.apache.commons.lang3.ArrayUtils;
import org.jyotisa.api.bhava.IBhavaEnum;
import org.jyotisa.api.dignity.IDignityEnum;
import org.jyotisa.api.graha.IGraha;
import org.jyotisa.api.graha.IGrahaEntity;
import org.jyotisa.api.graha.IGrahaEnum;
import org.jyotisa.api.karaka.ICharaKaraka;
import org.jyotisa.api.naksatra.INaksatraEnum;
import org.jyotisa.api.rasi.IRasiEnum;
import org.jyotisa.api.varga.IVargaEnum;
import org.jyotisa.bhava.EBhava;
import org.jyotisa.dignity.EDignity;
import org.jyotisa.graha.EGraha;
import org.jyotisa.karaka.ECharaKaraka;
import org.jyotisa.meta.options.MetaView;
import org.jyotisa.naksatra.ENaksatra;
import org.jyotisa.rasi.ERasi;
import org.jyotisa.varga.EVarga;
import org.swisseph.api.ISweEnumIterator;
import org.swisseph.app.SweEnumIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.jyotisa.api.varga.IVarga.D01_CD;
import static org.jyotisa.api.varga.IVarga.D09_CD;
import static org.jyotisa.graha.EGraha.KETU;
import static org.jyotisa.graha.EGraha.LAGNA;

public interface IMetaJyotisaConfig {
    MetaViewStyle[] DEFAULT_STYLES = MetaViewStyle.values();

    default MetaViewStyle[] confMetaStyles() {
        return DEFAULT_STYLES;
    }

    default boolean confMetaStyle(final MetaViewStyle style) {
        return ArrayUtils.contains(confMetaStyles(), style);
    }

    default Iterator<MetaView> confMetaViews() {
        final MetaViewStyle[] styles = confMetaStyles();

        if (null == styles || styles.length == 0) {
            throw new IllegalArgumentException("At least one style is required");
        }

        final List<MetaView> viewList = new ArrayList<>();
        for (MetaViewStyle style : styles) viewList.add(new MetaView(style, D01_CD));
        if (styles.length == 1) viewList.add(new MetaView(styles[0], D09_CD));

        return viewList.iterator();
    }

    default ISweEnumIterator<ICharaKaraka> confMetaCharaKarakas() {
        return ECharaKaraka.iterator();
    }

    default ISweEnumIterator<INaksatraEnum> confMetaNaksatras() {
        return ENaksatra.iterator();
    }

    default ISweEnumIterator<IDignityEnum> confMetaDignities() {
        return EDignity.iterator();
    }

    default ISweEnumIterator<IVargaEnum> confMetaVargas() {
        return EVarga.iterator();
    }

    default ISweEnumIterator<IBhavaEnum> confMetaBhavas() {
        return EBhava.iterator();
    }

    default ISweEnumIterator<IGrahaEnum> confMetaGrahas() {
        return new SweEnumIterator(EGraha.values(), LAGNA.uid(), KETU.uid());
    }

    default ISweEnumIterator<IRasiEnum> confMetaRasis() {
        return ERasi.iterator();
    }

    default IGrahaEntity[] confMetaFilter(IGrahaEntity[] all) {
        final List<IGraha> grahas = new ArrayList<>();
        confMetaGrahas().forEachRemaining(it -> grahas.add(it.graha()));
        return Stream.of(all).filter(it -> grahas.contains(it.entityEnum())).toArray(IGrahaEntity[]::new);
    }
}
