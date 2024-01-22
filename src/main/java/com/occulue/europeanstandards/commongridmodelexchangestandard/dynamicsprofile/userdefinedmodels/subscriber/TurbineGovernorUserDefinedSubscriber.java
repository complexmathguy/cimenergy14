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
 * Subscriber for TurbineGovernorUserDefined related events. .
 *
 * @author your_name_here
 */
@Component("turbineGovernorUserDefined-subscriber")
public class TurbineGovernorUserDefinedSubscriber extends BaseSubscriber {

  public TurbineGovernorUserDefinedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<TurbineGovernorUserDefined>, TurbineGovernorUserDefined>
      turbineGovernorUserDefinedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllTurbineGovernorUserDefinedQuery(),
        ResponseTypes.multipleInstancesOf(TurbineGovernorUserDefined.class),
        ResponseTypes.instanceOf(TurbineGovernorUserDefined.class));
  }

  public SubscriptionQueryResult<TurbineGovernorUserDefined, TurbineGovernorUserDefined>
      turbineGovernorUserDefinedSubscribe(@DestinationVariable UUID turbineGovernorUserDefinedId) {
    return queryGateway.subscriptionQuery(
        new FindTurbineGovernorUserDefinedQuery(
            new LoadTurbineGovernorUserDefinedFilter(turbineGovernorUserDefinedId)),
        ResponseTypes.instanceOf(TurbineGovernorUserDefined.class),
        ResponseTypes.instanceOf(TurbineGovernorUserDefined.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
