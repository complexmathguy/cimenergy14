/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for TextDiagramObject related events. .
 *
 * @author your_name_here
 */
@Component("textDiagramObject-subscriber")
public class TextDiagramObjectSubscriber extends BaseSubscriber {

  public TextDiagramObjectSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<TextDiagramObject>, TextDiagramObject>
      textDiagramObjectSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllTextDiagramObjectQuery(),
        ResponseTypes.multipleInstancesOf(TextDiagramObject.class),
        ResponseTypes.instanceOf(TextDiagramObject.class));
  }

  public SubscriptionQueryResult<TextDiagramObject, TextDiagramObject> textDiagramObjectSubscribe(
      @DestinationVariable UUID textDiagramObjectId) {
    return queryGateway.subscriptionQuery(
        new FindTextDiagramObjectQuery(new LoadTextDiagramObjectFilter(textDiagramObjectId)),
        ResponseTypes.instanceOf(TextDiagramObject.class),
        ResponseTypes.instanceOf(TextDiagramObject.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
