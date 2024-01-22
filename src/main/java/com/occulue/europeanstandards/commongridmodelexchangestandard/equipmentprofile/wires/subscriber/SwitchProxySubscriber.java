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
 * Subscriber for SwitchProxy related events. .
 *
 * @author your_name_here
 */
@Component("switchProxy-subscriber")
public class SwitchProxySubscriber extends BaseSubscriber {

  public SwitchProxySubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SwitchProxy>, SwitchProxy> switchProxySubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSwitchProxyQuery(),
        ResponseTypes.multipleInstancesOf(SwitchProxy.class),
        ResponseTypes.instanceOf(SwitchProxy.class));
  }

  public SubscriptionQueryResult<SwitchProxy, SwitchProxy> switchProxySubscribe(
      @DestinationVariable UUID switchProxyId) {
    return queryGateway.subscriptionQuery(
        new FindSwitchProxyQuery(new LoadSwitchProxyFilter(switchProxyId)),
        ResponseTypes.instanceOf(SwitchProxy.class),
        ResponseTypes.instanceOf(SwitchProxy.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
