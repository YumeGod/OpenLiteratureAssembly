/*
 * Decompiled with CFR 0_114.
 */
package just.monika.主播为什么开我端子.management.value;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.FIELD})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Val {
    public double min() default 1.0;

    public double max() default 10.0;

    public double increment() default 1.0;
}

