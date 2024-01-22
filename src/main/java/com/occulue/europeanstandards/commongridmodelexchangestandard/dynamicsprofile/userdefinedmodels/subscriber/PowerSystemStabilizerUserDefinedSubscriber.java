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
 * Subscriber for PowerSystemStabilizerUserDefined related events. .
 *
 * @author your_name_here
 */
@Component("powerSystemStabilizerUserDefined-subscriber")
public class PowerSystemStabilizerUserDefinedSubscriber extends BaseSubscriber {

  public PowerSystemStabilizerUserDefinedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<
          List<PowerSystemStabilizerUserDefined>, PowerSystemStabilizerUserDefined>
      powerSystemStabilizerUserDefinedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPowerSystemStabilizerUserDefinedQuery(),
        ResponseTypes.multipleInstancesOf(PowerSystemStabilizerUserDefined.class),
        ResponseTypes.instanceOf(PowerSystemStabilizerUserDefined.class));
  }

  public SubscriptionQueryResult<PowerSystemStabilizerUserDefined, PowerSystemStabilizerUserDefined>
      powerSystemStabilizerUserDefinedSubscribe(
          @DestinationVariable UUID powerSystemStabilizerUserDefinedId) {
    return queryGateway.subscriptionQuery(
        new FindPowerSystemStabilizerUserDefinedQuery(
            new LoadPowerSystemStabilizerUserDefinedFilter(powerSystemStabilizerUserDefinedId)),
        ResponseTypes.instanceOf(PowerSystemStabilizerUserDefined.class),
        ResponseTypes.instanceOf(PowerSystemStabilizerUserDefined.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
