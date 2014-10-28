package pw.swordfish.xposed.net.rtp;

import android.net.rtp.AudioCodec;
import static android.net.rtp.AudioCodec.*;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import pw.swordfish.util.Arrays;
import pw.swordfish.util.Function;

import static de.robv.android.xposed.XposedHelpers.setStaticObjectField;

public class AudioCodecOrder implements IXposedHookLoadPackage {
    private static final AudioCodec[] sCodecs = {PCMU, PCMA, GSM_EFR, AMR, GSM};
    private static final String LOGTAG = AudioCodecOrder.class.getName();

    private static final Function<AudioCodec, String> audioCodecToString = new Function<AudioCodec, String>() {
        @Override
        public String apply(AudioCodec o) {
            return o.rtpmap;
        }
    };

	public void handleLoadPackage(LoadPackageParam param) throws Throwable {
        //if (!param.packageName.equals("com.android.phone"))
        //    return;
        XposedBridge.log(LOGTAG + " " + Arrays.toString(sCodecs, audioCodecToString));
        setStaticObjectField(AudioCodec.class, "sCodecs", sCodecs);
        XposedBridge.log(LOGTAG + " " + Arrays.toString(sCodecs, audioCodecToString));
	}
}
