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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.subscriber;

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
 * Subscriber for ApparentPower related events. .
 *
 * @author your_name_here
 */
@Component("apparentPower-subscriber")
public class ApparentPowerSubscriber extends BaseSubscriber {

  public ApparentPowerSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ApparentPower>, ApparentPower> apparentPowerSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllApparentPowerQuery(),
        ResponseTypes.multipleInstancesOf(ApparentPower.class),
        ResponseTypes.instanceOf(ApparentPower.class));
  }

  public SubscriptionQueryResult<ApparentPower, ApparentPower> apparentPowerSubscribe(
      @DestinationVariable UUID apparentPowerId) {
    return queryGateway.subscriptionQuery(
        new FindApparentPowerQuery(new LoadApparentPowerFilter(apparentPowerId)),
        ResponseTypes.instanceOf(ApparentPower.class),
        ResponseTypes.instanceOf(ApparentPower.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
