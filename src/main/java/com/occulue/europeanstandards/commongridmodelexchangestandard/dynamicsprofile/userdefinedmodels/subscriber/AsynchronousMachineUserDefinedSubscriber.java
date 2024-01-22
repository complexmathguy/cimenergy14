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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.subscriber;

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
 * Subscriber for AsynchronousMachineUserDefined related events. .
 *
 * @author your_name_here
 */
@Component("asynchronousMachineUserDefined-subscriber")
public class AsynchronousMachineUserDefinedSubscriber extends BaseSubscriber {

  public AsynchronousMachineUserDefinedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<
          List<AsynchronousMachineUserDefined>, AsynchronousMachineUserDefined>
      asynchronousMachineUserDefinedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllAsynchronousMachineUserDefinedQuery(),
        ResponseTypes.multipleInstancesOf(AsynchronousMachineUserDefined.class),
        ResponseTypes.instanceOf(AsynchronousMachineUserDefined.class));
  }

  public SubscriptionQueryResult<AsynchronousMachineUserDefined, AsynchronousMachineUserDefined>
      asynchronousMachineUserDefinedSubscribe(
          @DestinationVariable UUID asynchronousMachineUserDefinedId) {
    return queryGateway.subscriptionQuery(
        new FindAsynchronousMachineUserDefinedQuery(
            new LoadAsynchronousMachineUserDefinedFilter(asynchronousMachineUserDefinedId)),
        ResponseTypes.instanceOf(AsynchronousMachineUserDefined.class),
        ResponseTypes.instanceOf(AsynchronousMachineUserDefined.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
