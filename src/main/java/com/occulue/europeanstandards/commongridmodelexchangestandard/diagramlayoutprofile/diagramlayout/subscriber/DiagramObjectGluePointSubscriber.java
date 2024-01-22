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
 * Subscriber for DiagramObjectGluePoint related events. .
 *
 * @author your_name_here
 */
@Component("diagramObjectGluePoint-subscriber")
public class DiagramObjectGluePointSubscriber extends BaseSubscriber {

  public DiagramObjectGluePointSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DiagramObjectGluePoint>, DiagramObjectGluePoint>
      diagramObjectGluePointSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDiagramObjectGluePointQuery(),
        ResponseTypes.multipleInstancesOf(DiagramObjectGluePoint.class),
        ResponseTypes.instanceOf(DiagramObjectGluePoint.class));
  }

  public SubscriptionQueryResult<DiagramObjectGluePoint, DiagramObjectGluePoint>
      diagramObjectGluePointSubscribe(@DestinationVariable UUID diagramObjectGluePointId) {
    return queryGateway.subscriptionQuery(
        new FindDiagramObjectGluePointQuery(
            new LoadDiagramObjectGluePointFilter(diagramObjectGluePointId)),
        ResponseTypes.instanceOf(DiagramObjectGluePoint.class),
        ResponseTypes.instanceOf(DiagramObjectGluePoint.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
