/*
 * This file is part of the Meeds project (https://meeds.io/).
 * Copyright (C) 2020 Meeds Association
 * contact@meeds.io
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.exoplatform.addons.es;

import java.util.Collection;

import org.elasticsearch.Version;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.InternalSettingsPreparer;
import org.elasticsearch.node.Node;
import org.elasticsearch.plugins.Plugin;

/**
 * Node allowing to declare a list of plugins
 */
public class EmbeddedNode extends Node {

  private Collection<Class<? extends Plugin>> plugins;

  public EmbeddedNode(Settings settings, Version version, Collection<Class<? extends Plugin>> classpathPlugins) {
    // Use internal class (InternalSettingsPreparer) to create an Environment the same way it is done
    // in standalone mode (load config file, system properties, replace placeholders, ...)
    super(InternalSettingsPreparer.prepareEnvironment(settings, null), classpathPlugins);
    this.plugins = classpathPlugins;
  }

  public Collection<Class<? extends Plugin>> getPlugins() {
    return plugins;
  }
}
