# Vaadin SVG-Addon project

based on an [Article by Matti Tahvonen](https://vaadin.com/blog/the-hidden-gem-of-vaadin-25-the-element-api-now-supports-svg-and-mathml), I created a few Java Classes representing SVG Elements.

## Usage

### in pom.xml
```
		<!-- Gork: SVG-addon         -->
		<!--       local usage      -->
        <dependency>
            <groupId>com.gork</groupId>
            <artifactId>svg-addon</artifactId>
			<version>1.0.0</version>
        </dependency>
```

### Application View

```
@Route(value = "svg-addon", layout = MainLayout.class)
public class SvgView extends VerticalLayout {

    public SvgView() {
        setSizeFull();

        SvgContainer svg = new SvgContainer();
        svg.setSizeFull();

        Circle circle = new Circle();
        circle.setRadius(30);
        circle.setCenter(100, 100);

        Rectangle rect = new Rectangle();
        rect.define(30, 50, 30, 50);

        Text text = new Text();
        text.setX(400);
        text.setY(400);
        text.add("SVG Text bla bla bla!");

        Line line = new Line(200, 100, 900, 400);

        Heart heart = new Heart();

        svg.add(circle, rect, text, line, heart);

        add(svg);
    }
}

```




