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
 * Subscriber for ExcAVR5 related events. .
 *
 * @author your_name_here
 */
@Component("excAVR5-subscriber")
public class ExcAVR5Subscriber extends BaseSubscriber {

  public ExcAVR5Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcAVR5>, ExcAVR5> excAVR5Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcAVR5Query(),
        ResponseTypes.multipleInstancesOf(ExcAVR5.class),
        ResponseTypes.instanceOf(ExcAVR5.class));
  }

  public SubscriptionQueryResult<ExcAVR5, ExcAVR5> excAVR5Subscribe(
      @DestinationVariable UUID excAVR5Id) {
    return queryGateway.subscriptionQuery(
        new FindExcAVR5Query(new LoadExcAVR5Filter(excAVR5Id)),
        ResponseTypes.instanceOf(ExcAVR5.class),
        ResponseTypes.instanceOf(ExcAVR5.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
