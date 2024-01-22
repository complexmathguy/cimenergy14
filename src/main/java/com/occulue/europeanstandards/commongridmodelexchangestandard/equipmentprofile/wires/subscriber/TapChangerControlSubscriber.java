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
 * Subscriber for TapChangerControl related events. .
 *
 * @author your_name_here
 */
@Component("tapChangerControl-subscriber")
public class TapChangerControlSubscriber extends BaseSubscriber {

  public TapChangerControlSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<TapChangerControl>, TapChangerControl>
      tapChangerControlSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllTapChangerControlQuery(),
        ResponseTypes.multipleInstancesOf(TapChangerControl.class),
        ResponseTypes.instanceOf(TapChangerControl.class));
  }

  public SubscriptionQueryResult<TapChangerControl, TapChangerControl> tapChangerControlSubscribe(
      @DestinationVariable UUID tapChangerControlId) {
    return queryGateway.subscriptionQuery(
        new FindTapChangerControlQuery(new LoadTapChangerControlFilter(tapChangerControlId)),
        ResponseTypes.instanceOf(TapChangerControl.class),
        ResponseTypes.instanceOf(TapChangerControl.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
