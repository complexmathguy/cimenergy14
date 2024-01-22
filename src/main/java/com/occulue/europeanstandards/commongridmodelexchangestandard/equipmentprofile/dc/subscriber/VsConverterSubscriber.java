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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.subscriber;

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
 * Subscriber for VsConverter related events. .
 *
 * @author your_name_here
 */
@Component("vsConverter-subscriber")
public class VsConverterSubscriber extends BaseSubscriber {

  public VsConverterSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<VsConverter>, VsConverter> vsConverterSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllVsConverterQuery(),
        ResponseTypes.multipleInstancesOf(VsConverter.class),
        ResponseTypes.instanceOf(VsConverter.class));
  }

  public SubscriptionQueryResult<VsConverter, VsConverter> vsConverterSubscribe(
      @DestinationVariable UUID vsConverterId) {
    return queryGateway.subscriptionQuery(
        new FindVsConverterQuery(new LoadVsConverterFilter(vsConverterId)),
        ResponseTypes.instanceOf(VsConverter.class),
        ResponseTypes.instanceOf(VsConverter.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
