package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({DrawModelTest.class,
            EllipseTest.class,
            FiveStarTest.class,
            LineTest.class,
            RectangleTest.class})
public class ModelTestSuite { // nothing
}