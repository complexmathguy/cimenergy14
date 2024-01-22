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
package com.occulue.europeanstandards.extension.operationallimits.subscriber;

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
 * Subscriber for ENTSOEOperationalLimitType related events. .
 *
 * @author your_name_here
 */
@Component("eNTSOEOperationalLimitType-subscriber")
public class ENTSOEOperationalLimitTypeSubscriber extends BaseSubscriber {

  public ENTSOEOperationalLimitTypeSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ENTSOEOperationalLimitType>, ENTSOEOperationalLimitType>
      eNTSOEOperationalLimitTypeSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllENTSOEOperationalLimitTypeQuery(),
        ResponseTypes.multipleInstancesOf(ENTSOEOperationalLimitType.class),
        ResponseTypes.instanceOf(ENTSOEOperationalLimitType.class));
  }

  public SubscriptionQueryResult<ENTSOEOperationalLimitType, ENTSOEOperationalLimitType>
      eNTSOEOperationalLimitTypeSubscribe(@DestinationVariable UUID eNTSOEOperationalLimitTypeId) {
    return queryGateway.subscriptionQuery(
        new FindENTSOEOperationalLimitTypeQuery(
            new LoadENTSOEOperationalLimitTypeFilter(eNTSOEOperationalLimitTypeId)),
        ResponseTypes.instanceOf(ENTSOEOperationalLimitType.class),
        ResponseTypes.instanceOf(ENTSOEOperationalLimitType.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
