/*
 * Decompiled with CFR 0_114.
 */
package just.monika.主播为什么开我端子.management.option;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.FIELD})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Op {
    public String name() default "null";
}

