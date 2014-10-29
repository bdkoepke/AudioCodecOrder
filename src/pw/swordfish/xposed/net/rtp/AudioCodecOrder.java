package pw.swordfish.xposed.net.rtp;

import static android.net.rtp.AudioCodec.*;

import android.net.rtp.AudioCodec;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XposedBridge;

import java.util.Arrays;

public class AudioCodecOrder implements IXposedHookZygoteInit {
    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        final String LOGTAG = AudioCodecOrder.class.getName();
        final AudioCodec[] codecs = {PCMU, PCMA, GSM_EFR, AMR, GSM};
        AudioCodecProxy.setCodecs(codecs);
        XposedBridge.log(LOGTAG +
                " " +
                (Arrays.equals(AudioCodecProxy.getCodecs(), codecs) ?
                        "Sucessfully" :
                        "Failed to") +
                " updated codec order");
    }


}
