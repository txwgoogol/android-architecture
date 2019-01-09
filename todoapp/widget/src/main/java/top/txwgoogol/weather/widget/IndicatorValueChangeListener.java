package top.txwgoogol.weather.widget;

public interface IndicatorValueChangeListener {

    void onChange(int currentIndicatorValue, String stateDescription, int indicatorTextColor);
}