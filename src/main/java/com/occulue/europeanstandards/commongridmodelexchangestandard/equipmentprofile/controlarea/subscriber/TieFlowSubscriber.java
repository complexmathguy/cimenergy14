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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.subscriber;

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
 * Subscriber for TieFlow related events. .
 *
 * @author your_name_here
 */
@Component("tieFlow-subscriber")
public class TieFlowSubscriber extends BaseSubscriber {

  public TieFlowSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<TieFlow>, TieFlow> tieFlowSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllTieFlowQuery(),
        ResponseTypes.multipleInstancesOf(TieFlow.class),
        ResponseTypes.instanceOf(TieFlow.class));
  }

  public SubscriptionQueryResult<TieFlow, TieFlow> tieFlowSubscribe(
      @DestinationVariable UUID tieFlowId) {
    return queryGateway.subscriptionQuery(
        new FindTieFlowQuery(new LoadTieFlowFilter(tieFlowId)),
        ResponseTypes.instanceOf(TieFlow.class),
        ResponseTypes.instanceOf(TieFlow.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
