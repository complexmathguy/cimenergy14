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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.subscriber;

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
 * Subscriber for SynchronousMachineDetailed related events. .
 *
 * @author your_name_here
 */
@Component("synchronousMachineDetailed-subscriber")
public class SynchronousMachineDetailedSubscriber extends BaseSubscriber {

  public SynchronousMachineDetailedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SynchronousMachineDetailed>, SynchronousMachineDetailed>
      synchronousMachineDetailedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSynchronousMachineDetailedQuery(),
        ResponseTypes.multipleInstancesOf(SynchronousMachineDetailed.class),
        ResponseTypes.instanceOf(SynchronousMachineDetailed.class));
  }

  public SubscriptionQueryResult<SynchronousMachineDetailed, SynchronousMachineDetailed>
      synchronousMachineDetailedSubscribe(@DestinationVariable UUID synchronousMachineDetailedId) {
    return queryGateway.subscriptionQuery(
        new FindSynchronousMachineDetailedQuery(
            new LoadSynchronousMachineDetailedFilter(synchronousMachineDetailedId)),
        ResponseTypes.instanceOf(SynchronousMachineDetailed.class),
        ResponseTypes.instanceOf(SynchronousMachineDetailed.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
