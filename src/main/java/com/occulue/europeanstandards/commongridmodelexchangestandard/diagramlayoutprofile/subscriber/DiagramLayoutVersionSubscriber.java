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
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.subscriber;

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
 * Subscriber for DiagramLayoutVersion related events. .
 *
 * @author your_name_here
 */
@Component("diagramLayoutVersion-subscriber")
public class DiagramLayoutVersionSubscriber extends BaseSubscriber {

  public DiagramLayoutVersionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DiagramLayoutVersion>, DiagramLayoutVersion>
      diagramLayoutVersionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDiagramLayoutVersionQuery(),
        ResponseTypes.multipleInstancesOf(DiagramLayoutVersion.class),
        ResponseTypes.instanceOf(DiagramLayoutVersion.class));
  }

  public SubscriptionQueryResult<DiagramLayoutVersion, DiagramLayoutVersion>
      diagramLayoutVersionSubscribe(@DestinationVariable UUID diagramLayoutVersionId) {
    return queryGateway.subscriptionQuery(
        new FindDiagramLayoutVersionQuery(
            new LoadDiagramLayoutVersionFilter(diagramLayoutVersionId)),
        ResponseTypes.instanceOf(DiagramLayoutVersion.class),
        ResponseTypes.instanceOf(DiagramLayoutVersion.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
