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
 * Subscriber for ExcAVR4 related events. .
 *
 * @author your_name_here
 */
@Component("excAVR4-subscriber")
public class ExcAVR4Subscriber extends BaseSubscriber {

  public ExcAVR4Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcAVR4>, ExcAVR4> excAVR4Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcAVR4Query(),
        ResponseTypes.multipleInstancesOf(ExcAVR4.class),
        ResponseTypes.instanceOf(ExcAVR4.class));
  }

  public SubscriptionQueryResult<ExcAVR4, ExcAVR4> excAVR4Subscribe(
      @DestinationVariable UUID excAVR4Id) {
    return queryGateway.subscriptionQuery(
        new FindExcAVR4Query(new LoadExcAVR4Filter(excAVR4Id)),
        ResponseTypes.instanceOf(ExcAVR4.class),
        ResponseTypes.instanceOf(ExcAVR4.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
