package programmingproject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class ScreenManager {

    private GraphicsDevice vc;

    //Give acces to monitor screen
    public ScreenManager() {
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc = e.getDefaultScreenDevice();
    }

    //get all compatible DM
    public DisplayMode[] getCompatibleDisplayModes() {
        return vc.getDisplayModes();
    }

    //Compares DM passed in to vc DM & see if they match
    public DisplayMode findFirstCompatibleMode(DisplayMode modes[]) {
        DisplayMode goodModes[] = vc.getDisplayModes();
        for (int x = 0; x < modes.length; x++) {
            for (int y = 0; y < goodModes.length; y++) {
                if (displayModesMatch(modes[x], goodModes[y])) {
                    return modes[x];
                }
            }
        }
        return null;
    }

    //get current DM
    public DisplayMode getCurrentDisplayMode() {
        return vc.getDisplayMode();
    }

    //check if two modes match each other
    public boolean displayModesMatch(DisplayMode m1, DisplayMode m2) {
        if (m1.getWidth() != m2.getWidth() || m1.getHeight() != m2.getHeight()) {
            return false;
        }
        if (m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m1.getBitDepth() != m2.getBitDepth()) {
            return false;
        }
        if (m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m1.getRefreshRate() != m2.getRefreshRate()) {
            return false;
        }
        return true;
    }

    //Make frame full screen
    public void setFullScreen(DisplayMode dm) {
        JFrame f = new JFrame();
        f.setUndecorated(true);
        f.setIgnoreRepaint(true);
        f.setResizable(false);
        vc.setFullScreenWindow(f);

        if (dm != null && vc.isDisplayChangeSupported()) {
            try {
                vc.setDisplayMode(dm);
            } catch (Exception ex) {
            }
        }
        f.createBufferStrategy(2);
    }

    //set Graphics object = to that
    public Graphics2D getGraphics() {
        Window w = vc.getFullScreenWindow();
        if (w != null) {
            BufferStrategy s = w.getBufferStrategy();
            return (Graphics2D) s.getDrawGraphics();
        } else {
            return null;
        }
    }

    //updates display
    public void update() {
        Window w = vc.getFullScreenWindow();
        if (w != null) {
            BufferStrategy s = w.getBufferStrategy();
            if (!s.contentsLost()) {
                s.show();
            }
        }
    }

    //return full screen window
    public Window getFullScreenWindow() {
        return vc.getFullScreenWindow();
    }

    //get width
    public int getWidth() {
        Window w = vc.getFullScreenWindow();
        if (w != null) {
            return w.getWidth();
        } else {
            return 0;
        }
    }

    //get Height
    public int getHeight() {
        Window w = vc.getFullScreenWindow();
        if (w != null) {
            return w.getHeight();
        } else {
            return 0;
        }
    }

    //get out of full screen
    public void restoreScreen() {
        Window w = vc.getFullScreenWindow();
        if (w != null) {
            w.dispose();
        }
        vc.setFullScreenWindow(null);
    }

    //create image compatible with monitor
    public BufferedImage createCompatibleImage(int w, int h, int t) {
        Window win = vc.getFullScreenWindow();
        if (win != null) {
            GraphicsConfiguration gc = win.getGraphicsConfiguration();
            return gc.createCompatibleImage(w, h, t);
        }
        return null;
    }
}
