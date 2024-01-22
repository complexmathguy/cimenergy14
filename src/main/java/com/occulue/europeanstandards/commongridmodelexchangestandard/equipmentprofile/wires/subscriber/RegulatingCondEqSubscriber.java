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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.subscriber;

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
 * Subscriber for RegulatingCondEq related events. .
 *
 * @author your_name_here
 */
@Component("regulatingCondEq-subscriber")
public class RegulatingCondEqSubscriber extends BaseSubscriber {

  public RegulatingCondEqSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<RegulatingCondEq>, RegulatingCondEq>
      regulatingCondEqSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllRegulatingCondEqQuery(),
        ResponseTypes.multipleInstancesOf(RegulatingCondEq.class),
        ResponseTypes.instanceOf(RegulatingCondEq.class));
  }

  public SubscriptionQueryResult<RegulatingCondEq, RegulatingCondEq> regulatingCondEqSubscribe(
      @DestinationVariable UUID regulatingCondEqId) {
    return queryGateway.subscriptionQuery(
        new FindRegulatingCondEqQuery(new LoadRegulatingCondEqFilter(regulatingCondEqId)),
        ResponseTypes.instanceOf(RegulatingCondEq.class),
        ResponseTypes.instanceOf(RegulatingCondEq.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
