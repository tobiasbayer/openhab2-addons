/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.feed.internal;

import static org.openhab.binding.feed.FeedBindingConstants.FEED_THING_TYPE_UID;

import java.util.Collections;
import java.util.Set;

import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.eclipse.smarthome.core.thing.binding.ThingHandlerFactory;
import org.openhab.binding.feed.handler.FeedHandler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

/**
 * The {@link FeedHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author Svilen Valkanov - Initial contribution
 */
@Component(service = ThingHandlerFactory.class, immediate = true, configurationPid = "binding.feed", configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class FeedHandlerFactory extends BaseThingHandlerFactory {

    private static final Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Collections.singleton(FEED_THING_TYPE_UID);

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected ThingHandler createHandler(Thing thing) {
        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (thingTypeUID.equals(FEED_THING_TYPE_UID)) {
            return new FeedHandler(thing);
        }

        return null;
    }
}
