package framework.core.holders;

public interface IHolder {
    IHolder restore();
    IHolder call(Object... callables);
}
