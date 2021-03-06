/*
 * Copyright 2015-2018 Igor Maznitsa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.igormaznitsa.mindmap.plugins.processors;

import com.igormaznitsa.mindmap.model.Extra;
import com.igormaznitsa.mindmap.model.Topic;
import com.igormaznitsa.mindmap.plugins.PopUpSection;
import com.igormaznitsa.mindmap.plugins.api.AbstractFocusedTopicPlugin;
import com.igormaznitsa.mindmap.plugins.api.ExternallyExecutedPlugin;
import com.igormaznitsa.mindmap.plugins.api.PluginContext;
import com.igormaznitsa.mindmap.swing.panel.Texts;
import com.igormaznitsa.mindmap.swing.services.IconID;
import com.igormaznitsa.mindmap.swing.services.ImageIconServiceProvider;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.swing.Icon;

public class ExtraFilePlugin extends AbstractFocusedTopicPlugin implements ExternallyExecutedPlugin {

  private static final Icon ICO = ImageIconServiceProvider.findInstance().getIconForId(IconID.POPUP_EXTRAS_FILE);

  @Override
  public int getOrder() {
    return 2;
  }

  @Override
  @Nullable
  protected Icon getIcon(@Nonnull final PluginContext context, @Nullable final Topic actionTopic) {
    return ICO;
  }

  @Override
  @Nonnull
  protected String getName(@Nonnull final PluginContext context, @Nullable final Topic actionTopic) {
    if (actionTopic == null) {
      return "...";
    }
    return actionTopic.getExtras().containsKey(Extra.ExtraType.FILE) ? Texts.getString("MMDGraphEditor.makePopUp.miEditFile")
        : Texts.getString("MMDGraphEditor.makePopUp.miAddFile");
  }

  @Override
  @Nonnull
  public PopUpSection getSection() {
    return PopUpSection.EXTRAS;
  }

}
