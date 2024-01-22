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
 * Subscriber for VisibilityLayer related events. .
 *
 * @author your_name_here
 */
@Component("visibilityLayer-subscriber")
public class VisibilityLayerSubscriber extends BaseSubscriber {

  public VisibilityLayerSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<VisibilityLayer>, VisibilityLayer>
      visibilityLayerSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllVisibilityLayerQuery(),
        ResponseTypes.multipleInstancesOf(VisibilityLayer.class),
        ResponseTypes.instanceOf(VisibilityLayer.class));
  }

  public SubscriptionQueryResult<VisibilityLayer, VisibilityLayer> visibilityLayerSubscribe(
      @DestinationVariable UUID visibilityLayerId) {
    return queryGateway.subscriptionQuery(
        new FindVisibilityLayerQuery(new LoadVisibilityLayerFilter(visibilityLayerId)),
        ResponseTypes.instanceOf(VisibilityLayer.class),
        ResponseTypes.instanceOf(VisibilityLayer.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
