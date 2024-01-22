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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.subscriber;

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
 * Subscriber for ExcIEEEAC3A related events. .
 *
 * @author your_name_here
 */
@Component("excIEEEAC3A-subscriber")
public class ExcIEEEAC3ASubscriber extends BaseSubscriber {

  public ExcIEEEAC3ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcIEEEAC3A>, ExcIEEEAC3A> excIEEEAC3ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcIEEEAC3AQuery(),
        ResponseTypes.multipleInstancesOf(ExcIEEEAC3A.class),
        ResponseTypes.instanceOf(ExcIEEEAC3A.class));
  }

  public SubscriptionQueryResult<ExcIEEEAC3A, ExcIEEEAC3A> excIEEEAC3ASubscribe(
      @DestinationVariable UUID excIEEEAC3AId) {
    return queryGateway.subscriptionQuery(
        new FindExcIEEEAC3AQuery(new LoadExcIEEEAC3AFilter(excIEEEAC3AId)),
        ResponseTypes.instanceOf(ExcIEEEAC3A.class),
        ResponseTypes.instanceOf(ExcIEEEAC3A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
