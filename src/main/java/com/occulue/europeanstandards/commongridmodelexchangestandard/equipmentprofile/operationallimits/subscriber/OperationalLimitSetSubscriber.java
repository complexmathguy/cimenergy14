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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.subscriber;

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
 * Subscriber for OperationalLimitSet related events. .
 *
 * @author your_name_here
 */
@Component("operationalLimitSet-subscriber")
public class OperationalLimitSetSubscriber extends BaseSubscriber {

  public OperationalLimitSetSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<OperationalLimitSet>, OperationalLimitSet>
      operationalLimitSetSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllOperationalLimitSetQuery(),
        ResponseTypes.multipleInstancesOf(OperationalLimitSet.class),
        ResponseTypes.instanceOf(OperationalLimitSet.class));
  }

  public SubscriptionQueryResult<OperationalLimitSet, OperationalLimitSet>
      operationalLimitSetSubscribe(@DestinationVariable UUID operationalLimitSetId) {
    return queryGateway.subscriptionQuery(
        new FindOperationalLimitSetQuery(new LoadOperationalLimitSetFilter(operationalLimitSetId)),
        ResponseTypes.instanceOf(OperationalLimitSet.class),
        ResponseTypes.instanceOf(OperationalLimitSet.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
