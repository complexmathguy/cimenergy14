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
 * Subscriber for SynchronousMachineUserDefined related events. .
 *
 * @author your_name_here
 */
@Component("synchronousMachineUserDefined-subscriber")
public class SynchronousMachineUserDefinedSubscriber extends BaseSubscriber {

  public SynchronousMachineUserDefinedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SynchronousMachineUserDefined>, SynchronousMachineUserDefined>
      synchronousMachineUserDefinedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSynchronousMachineUserDefinedQuery(),
        ResponseTypes.multipleInstancesOf(SynchronousMachineUserDefined.class),
        ResponseTypes.instanceOf(SynchronousMachineUserDefined.class));
  }

  public SubscriptionQueryResult<SynchronousMachineUserDefined, SynchronousMachineUserDefined>
      synchronousMachineUserDefinedSubscribe(
          @DestinationVariable UUID synchronousMachineUserDefinedId) {
    return queryGateway.subscriptionQuery(
        new FindSynchronousMachineUserDefinedQuery(
            new LoadSynchronousMachineUserDefinedFilter(synchronousMachineUserDefinedId)),
        ResponseTypes.instanceOf(SynchronousMachineUserDefined.class),
        ResponseTypes.instanceOf(SynchronousMachineUserDefined.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
