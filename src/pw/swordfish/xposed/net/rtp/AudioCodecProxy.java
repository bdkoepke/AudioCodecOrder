package pw.swordfish.xposed.net.rtp;

import android.net.rtp.AudioCodec;

import static de.robv.android.xposed.XposedHelpers.getStaticObjectField;
import static de.robv.android.xposed.XposedHelpers.setStaticObjectField;

public class AudioCodecProxy {
    private static final String sCodecs = "sCodecs";
    public static void setCodecs(AudioCodec[] c) {
        setStaticObjectField(AudioCodec.class, sCodecs, c);
    }
    public static AudioCodec[] getCodecs() {
        return (AudioCodec[]) getStaticObjectField(AudioCodec.class, sCodecs);
    }
}
