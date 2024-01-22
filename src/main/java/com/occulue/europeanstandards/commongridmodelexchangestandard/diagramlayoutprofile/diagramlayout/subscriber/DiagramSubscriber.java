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
 * Subscriber for Diagram related events. .
 *
 * @author your_name_here
 */
@Component("diagram-subscriber")
public class DiagramSubscriber extends BaseSubscriber {

  public DiagramSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Diagram>, Diagram> diagramSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDiagramQuery(),
        ResponseTypes.multipleInstancesOf(Diagram.class),
        ResponseTypes.instanceOf(Diagram.class));
  }

  public SubscriptionQueryResult<Diagram, Diagram> diagramSubscribe(
      @DestinationVariable UUID diagramId) {
    return queryGateway.subscriptionQuery(
        new FindDiagramQuery(new LoadDiagramFilter(diagramId)),
        ResponseTypes.instanceOf(Diagram.class),
        ResponseTypes.instanceOf(Diagram.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
