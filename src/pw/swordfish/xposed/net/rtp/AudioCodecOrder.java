package pw.swordfish.xposed.net.rtp;

import android.net.rtp.AudioCodec;
import static android.net.rtp.AudioCodec.*;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.setStaticObjectField;

public class AudioCodecOrder implements IXposedHookLoadPackage {
    private static final AudioCodec[] sCodecs = {PCMU, PCMA, GSM_EFR, AMR, GSM};

	public void handleLoadPackage(LoadPackageParam param) throws Throwable {
        if (!param.packageName.equals("com.android.phone"))
            return;
        setStaticObjectField(AudioCodec.class, "sCodecs", sCodecs);
	}
}
