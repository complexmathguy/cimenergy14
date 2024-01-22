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
 * Subscriber for OperationalLimitType related events. .
 *
 * @author your_name_here
 */
@Component("operationalLimitType-subscriber")
public class OperationalLimitTypeSubscriber extends BaseSubscriber {

  public OperationalLimitTypeSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<OperationalLimitType>, OperationalLimitType>
      operationalLimitTypeSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllOperationalLimitTypeQuery(),
        ResponseTypes.multipleInstancesOf(OperationalLimitType.class),
        ResponseTypes.instanceOf(OperationalLimitType.class));
  }

  public SubscriptionQueryResult<OperationalLimitType, OperationalLimitType>
      operationalLimitTypeSubscribe(@DestinationVariable UUID operationalLimitTypeId) {
    return queryGateway.subscriptionQuery(
        new FindOperationalLimitTypeQuery(
            new LoadOperationalLimitTypeFilter(operationalLimitTypeId)),
        ResponseTypes.instanceOf(OperationalLimitType.class),
        ResponseTypes.instanceOf(OperationalLimitType.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
