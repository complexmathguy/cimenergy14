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
 * Subscriber for ApparentPowerLimit related events. .
 *
 * @author your_name_here
 */
@Component("apparentPowerLimit-subscriber")
public class ApparentPowerLimitSubscriber extends BaseSubscriber {

  public ApparentPowerLimitSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ApparentPowerLimit>, ApparentPowerLimit>
      apparentPowerLimitSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllApparentPowerLimitQuery(),
        ResponseTypes.multipleInstancesOf(ApparentPowerLimit.class),
        ResponseTypes.instanceOf(ApparentPowerLimit.class));
  }

  public SubscriptionQueryResult<ApparentPowerLimit, ApparentPowerLimit>
      apparentPowerLimitSubscribe(@DestinationVariable UUID apparentPowerLimitId) {
    return queryGateway.subscriptionQuery(
        new FindApparentPowerLimitQuery(new LoadApparentPowerLimitFilter(apparentPowerLimitId)),
        ResponseTypes.instanceOf(ApparentPowerLimit.class),
        ResponseTypes.instanceOf(ApparentPowerLimit.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
