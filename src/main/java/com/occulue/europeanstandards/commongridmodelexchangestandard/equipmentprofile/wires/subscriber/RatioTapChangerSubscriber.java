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
 * Subscriber for RatioTapChanger related events. .
 *
 * @author your_name_here
 */
@Component("ratioTapChanger-subscriber")
public class RatioTapChangerSubscriber extends BaseSubscriber {

  public RatioTapChangerSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<RatioTapChanger>, RatioTapChanger>
      ratioTapChangerSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllRatioTapChangerQuery(),
        ResponseTypes.multipleInstancesOf(RatioTapChanger.class),
        ResponseTypes.instanceOf(RatioTapChanger.class));
  }

  public SubscriptionQueryResult<RatioTapChanger, RatioTapChanger> ratioTapChangerSubscribe(
      @DestinationVariable UUID ratioTapChangerId) {
    return queryGateway.subscriptionQuery(
        new FindRatioTapChangerQuery(new LoadRatioTapChangerFilter(ratioTapChangerId)),
        ResponseTypes.instanceOf(RatioTapChanger.class),
        ResponseTypes.instanceOf(RatioTapChanger.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
