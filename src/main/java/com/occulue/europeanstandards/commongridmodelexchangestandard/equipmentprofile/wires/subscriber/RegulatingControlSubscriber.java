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
 * Subscriber for RegulatingControl related events. .
 *
 * @author your_name_here
 */
@Component("regulatingControl-subscriber")
public class RegulatingControlSubscriber extends BaseSubscriber {

  public RegulatingControlSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<RegulatingControl>, RegulatingControl>
      regulatingControlSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllRegulatingControlQuery(),
        ResponseTypes.multipleInstancesOf(RegulatingControl.class),
        ResponseTypes.instanceOf(RegulatingControl.class));
  }

  public SubscriptionQueryResult<RegulatingControl, RegulatingControl> regulatingControlSubscribe(
      @DestinationVariable UUID regulatingControlId) {
    return queryGateway.subscriptionQuery(
        new FindRegulatingControlQuery(new LoadRegulatingControlFilter(regulatingControlId)),
        ResponseTypes.instanceOf(RegulatingControl.class),
        ResponseTypes.instanceOf(RegulatingControl.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
