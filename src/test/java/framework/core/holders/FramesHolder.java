package framework.core.holders;

import com.github.marcosbelfastdev.erbium.core.Driver;

public class FramesHolder {
    Driver $driver;
    Class<?> $frameBaseClass;
    Object iframeBase;

    public FramesHolder(Driver driver, Class<?> baseFrameClass) {
        this.$driver = driver;
        this.$frameBaseClass = baseFrameClass;
        this.restore();
        this.iframeBase = new FrameInit(driver, baseFrameClass);
    }

    public static FramesHolder init(Driver driver, Class<?> classeIframeBase) {
        return new FramesHolder(driver, classeIframeBase);
    }

    /**
     * Redefine o documento HTML atual para o frame determinado
     * na classe de frame
     * @return
     */
    public FramesHolder restoreBaseFrame() {
        this.iframeBase = new FrameInit($driver, $frameBaseClass);
        return this;
    }

    /**
     * @param callables
     * @return
     * @param <T>
     */
    public <T> FramesHolder call(T... callables) {
        return this;
    }

    /**
     * na funcionalidade
     */
    public void restore() {
        $driver.getWrappedWebDriver().switchTo().defaultContent();
    }

    /**
     * e continuar a selecionar um iframe filho de modo relativo a esse
     * iframe de base, utilizando sempre classes de frame
     * @return
     * @throws Exception
     */
    public final FramesHolder gotoNestedFrames(Class<?>... classesFrameBase) {
        $driver.getWrappedWebDriver().switchTo().defaultContent();
        new FrameInit($driver, classesFrameBase[0]);
        for (int i=1; i<classesFrameBase.length; i++) {
            new FrameInit($driver, classesFrameBase[i]);
        }
        return this;
    }
}
