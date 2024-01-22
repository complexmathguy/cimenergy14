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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.subscriber;

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
 * Subscriber for Line related events. .
 *
 * @author your_name_here
 */
@Component("line-subscriber")
public class LineSubscriber extends BaseSubscriber {

  public LineSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Line>, Line> lineSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllLineQuery(),
        ResponseTypes.multipleInstancesOf(Line.class),
        ResponseTypes.instanceOf(Line.class));
  }

  public SubscriptionQueryResult<Line, Line> lineSubscribe(@DestinationVariable UUID lineId) {
    return queryGateway.subscriptionQuery(
        new FindLineQuery(new LoadLineFilter(lineId)),
        ResponseTypes.instanceOf(Line.class),
        ResponseTypes.instanceOf(Line.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
