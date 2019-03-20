package ch29.j;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
    basePackages={"ch29.j","ch29.j2"},
    excludeFilters= {
        @ComponentScan.Filter(
            type=FilterType.REGEX,
            pattern="ch29.j.Car"
        ),
        @ComponentScan.Filter(
            type=FilterType.REGEX,
            pattern="ch29.j.AppConfig2"
        )}
)
public class AppConfig3 {
  
  
}
