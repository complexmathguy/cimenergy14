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
 * Subscriber for Money related events. .
 *
 * @author your_name_here
 */
@Component("money-subscriber")
public class MoneySubscriber extends BaseSubscriber {

  public MoneySubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Money>, Money> moneySubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllMoneyQuery(),
        ResponseTypes.multipleInstancesOf(Money.class),
        ResponseTypes.instanceOf(Money.class));
  }

  public SubscriptionQueryResult<Money, Money> moneySubscribe(@DestinationVariable UUID moneyId) {
    return queryGateway.subscriptionQuery(
        new FindMoneyQuery(new LoadMoneyFilter(moneyId)),
        ResponseTypes.instanceOf(Money.class),
        ResponseTypes.instanceOf(Money.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
