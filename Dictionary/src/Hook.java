
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HMODULE;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinUser.HHOOK;
import com.sun.jna.platform.win32.WinUser.KBDLLHOOKSTRUCT;
import com.sun.jna.platform.win32.WinUser.LowLevelKeyboardProc;
import com.sun.jna.platform.win32.WinUser.MSG;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;

import com.sun.jna.Platform;
import com.sun.jna.platform.unix.X11;
import com.sun.jna.platform.unix.X11.Display;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinUser;
/**
 * Sample implementation of a low-level keyboard hook on W32.
 */
public class Hook extends Dictionary implements Runnable  {
    private static volatile boolean quit;
    private static HHOOK hhk;
    private static LowLevelKeyboardProc keyboardHook;
    private static KeyboardUtils kb;
    private static boolean visible;          
    public  void run() {
        final User32 lib = User32.INSTANCE;
        HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
        visible = true;
        kb = new KeyboardUtils();
        keyboardHook = new LowLevelKeyboardProc() {
            public LRESULT callback(int nCode, WPARAM wParam, KBDLLHOOKSTRUCT info) {
            	if (nCode >= 0) { 
                    switch (wParam.intValue()) {
                        case User32.WM_KEYUP:
                        	System.err.println("up, key=" + info.vkCode);
                            if (info.vkCode == 81) {
                                quit = true;
                            }
                            break;
                        case User32.WM_KEYDOWN:
                        	System.err.println("down, key=" + info.vkCode);
                        	if(KeyboardUtils.isPressed(KeyEvent.VK_CONTROL, KeyEvent.KEY_LOCATION_LEFT)== true && info.vkCode == 164)
                        	{
                        		System.out.println("hook");
                        		if(visible == false)
                        		{
                        			System.out.println("Hiện");
                        			swingGUI.visible(true);
                        			visible = true;
                        		}
                        		else
                        		{
                        			
                        			swingGUI.visible(false);
                        			
                        			System.out.println("Ẩn");
                        			visible = false;
                        		}
                        			
                        	}
                            if (info.vkCode == 81) {
                                quit = true;
                            }
                            break;
                        case User32.WM_SYSKEYUP:
                            break;
                        case User32.WM_SYSKEYDOWN:
                            break;
                    }
                    
                }
            	Pointer ptr = info.getPointer();
                long peer = Pointer.nativeValue(ptr);
                return lib.CallNextHookEx(hhk, nCode, wParam, new WinDef.LPARAM(peer));
            }
        };
        hhk = lib.SetWindowsHookEx(User32.WH_KEYBOARD_LL, keyboardHook, hMod, 0);
        System.out.println("Keyboard hook installed, type anywhere, 'q' to quit");
        //noinspection ConstantConditions
        new Thread() {
            public void run() {
                while (!quit) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.err.println("unhook and exit");
                lib.UnhookWindowsHookEx(hhk);
                System.exit(0);
            }
        }.start();
        // This bit never returns from GetMessage
        MSG msg = new MSG();
        while ((lib.GetMessage(msg, null, 0, 0)) != 0) {
                lib.TranslateMessage(msg);
                lib.DispatchMessage(msg);
        }
        lib.UnhookWindowsHookEx(hhk); 
    } 
}
