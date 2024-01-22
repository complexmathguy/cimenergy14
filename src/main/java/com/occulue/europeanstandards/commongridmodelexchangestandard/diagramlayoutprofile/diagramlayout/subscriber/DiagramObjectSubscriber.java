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
 * Subscriber for DiagramObject related events. .
 *
 * @author your_name_here
 */
@Component("diagramObject-subscriber")
public class DiagramObjectSubscriber extends BaseSubscriber {

  public DiagramObjectSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DiagramObject>, DiagramObject> diagramObjectSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDiagramObjectQuery(),
        ResponseTypes.multipleInstancesOf(DiagramObject.class),
        ResponseTypes.instanceOf(DiagramObject.class));
  }

  public SubscriptionQueryResult<DiagramObject, DiagramObject> diagramObjectSubscribe(
      @DestinationVariable UUID diagramObjectId) {
    return queryGateway.subscriptionQuery(
        new FindDiagramObjectQuery(new LoadDiagramObjectFilter(diagramObjectId)),
        ResponseTypes.instanceOf(DiagramObject.class),
        ResponseTypes.instanceOf(DiagramObject.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
