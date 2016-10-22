package spark.utils;

import java.lang.reflect.Field;

import org.apache.commons.lang3.reflect.FieldUtils;

import spark.template.handlebars.HandlebarsTemplateEngine;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.HumanizeHelper;
import com.github.jknack.handlebars.helper.I18nHelper;
import com.github.jknack.handlebars.helper.NumberHelper;
import com.github.jknack.handlebars.helper.StringHelpers;

public class HandlebarsTemplateEngineBuilder {

	private HandlebarsTemplateEngine engine;

	private HandlebarsTemplateEngineBuilder(HandlebarsTemplateEngine engine) {
		this.engine = engine;
	}

	public static HandlebarsTemplateEngineBuilder create() {
		return new HandlebarsTemplateEngineBuilder(
				new HandlebarsTemplateEngine());
	}

	public HandlebarsTemplateEngineBuilder withHelper(String name,
			Helper<?> helper) {
		getHandlerbars().registerHelper(name, helper);
		return this;
	}

	private Handlebars getHandlerbars() {
		try {
			Field field = FieldUtils.getField(this.engine.getClass(),
					"handlebars", true);
			return (Handlebars) field.get(this.engine);
		} catch (Exception e) {
			throw new RuntimeException("cannot get handlebars", e);
		}
	}

	public HandlebarsTemplateEngine build() {
		return engine;
	}

	public HandlebarsTemplateEngineBuilder withDefaultHelpers() {
		StringHelpers.register(getHandlerbars());
		NumberHelper.register(getHandlerbars());
		HumanizeHelper.register(getHandlerbars());
		withHelper("i18n", I18nHelper.i18n);
		return this;
	}
}
