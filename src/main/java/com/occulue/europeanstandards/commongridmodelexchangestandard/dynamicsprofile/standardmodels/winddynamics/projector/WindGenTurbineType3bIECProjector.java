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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for WindGenTurbineType3bIEC as outlined for the CQRS pattern. All event handling and
 * query handling related to WindGenTurbineType3bIEC are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by WindGenTurbineType3bIECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windGenTurbineType3bIEC")
@Component("windGenTurbineType3bIEC-projector")
public class WindGenTurbineType3bIECProjector extends WindGenTurbineType3bIECEntityProjector {

  // core constructor
  public WindGenTurbineType3bIECProjector(
      WindGenTurbineType3bIECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindGenTurbineType3bIECEvent
   */
  @EventHandler(payloadType = CreateWindGenTurbineType3bIECEvent.class)
  public void handle(CreateWindGenTurbineType3bIECEvent event) {
    LOGGER.info("handling CreateWindGenTurbineType3bIECEvent - " + event);
    WindGenTurbineType3bIEC entity = new WindGenTurbineType3bIEC();
    entity.setWindGenTurbineType3bIECId(event.getWindGenTurbineType3bIECId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenTurbineType3bIEC(entity);
  }

  /*
   * @param	event UpdateWindGenTurbineType3bIECEvent
   */
  @EventHandler(payloadType = UpdateWindGenTurbineType3bIECEvent.class)
  public void handle(UpdateWindGenTurbineType3bIECEvent event) {
    LOGGER.info("handling UpdateWindGenTurbineType3bIECEvent - " + event);

    WindGenTurbineType3bIEC entity = new WindGenTurbineType3bIEC();
    entity.setWindGenTurbineType3bIECId(event.getWindGenTurbineType3bIECId());
    entity.setFducw(event.getFducw());
    entity.setMwtcwp(event.getMwtcwp());
    entity.setTg(event.getTg());
    entity.setTwo(event.getTwo());
    entity.setXs(event.getXs());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenTurbineType3bIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenTurbineType3bIEC(entity);
  }

  /*
   * @param	event DeleteWindGenTurbineType3bIECEvent
   */
  @EventHandler(payloadType = DeleteWindGenTurbineType3bIECEvent.class)
  public void handle(DeleteWindGenTurbineType3bIECEvent event) {
    LOGGER.info("handling DeleteWindGenTurbineType3bIECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindGenTurbineType3bIEC entity = delete(event.getWindGenTurbineType3bIECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenTurbineType3bIEC(entity);
  }

  /*
   * @param	event AssignFducwToWindGenTurbineType3bIECEvent
   */
  @EventHandler(payloadType = AssignFducwToWindGenTurbineType3bIECEvent.class)
  public void handle(AssignFducwToWindGenTurbineType3bIECEvent event) {
    LOGGER.info("handling AssignFducwToWindGenTurbineType3bIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindGenTurbineType3bIEC entity =
        assignFducw(event.getWindGenTurbineType3bIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenTurbineType3bIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenTurbineType3bIEC(entity);
  }

  /*
   * @param	event UnAssignFducwFromWindGenTurbineType3bIECEvent
   */
  @EventHandler(payloadType = UnAssignFducwFromWindGenTurbineType3bIECEvent.class)
  public void handle(UnAssignFducwFromWindGenTurbineType3bIECEvent event) {
    LOGGER.info("handling UnAssignFducwFromWindGenTurbineType3bIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindGenTurbineType3bIEC entity = unAssignFducw(event.getWindGenTurbineType3bIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenTurbineType3bIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenTurbineType3bIEC(entity);
  }

  /*
   * @param	event AssignMwtcwpToWindGenTurbineType3bIECEvent
   */
  @EventHandler(payloadType = AssignMwtcwpToWindGenTurbineType3bIECEvent.class)
  public void handle(AssignMwtcwpToWindGenTurbineType3bIECEvent event) {
    LOGGER.info("handling AssignMwtcwpToWindGenTurbineType3bIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindGenTurbineType3bIEC entity =
        assignMwtcwp(event.getWindGenTurbineType3bIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenTurbineType3bIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenTurbineType3bIEC(entity);
  }

  /*
   * @param	event UnAssignMwtcwpFromWindGenTurbineType3bIECEvent
   */
  @EventHandler(payloadType = UnAssignMwtcwpFromWindGenTurbineType3bIECEvent.class)
  public void handle(UnAssignMwtcwpFromWindGenTurbineType3bIECEvent event) {
    LOGGER.info("handling UnAssignMwtcwpFromWindGenTurbineType3bIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindGenTurbineType3bIEC entity = unAssignMwtcwp(event.getWindGenTurbineType3bIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenTurbineType3bIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenTurbineType3bIEC(entity);
  }

  /*
   * @param	event AssignTgToWindGenTurbineType3bIECEvent
   */
  @EventHandler(payloadType = AssignTgToWindGenTurbineType3bIECEvent.class)
  public void handle(AssignTgToWindGenTurbineType3bIECEvent event) {
    LOGGER.info("handling AssignTgToWindGenTurbineType3bIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindGenTurbineType3bIEC entity =
        assignTg(event.getWindGenTurbineType3bIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenTurbineType3bIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenTurbineType3bIEC(entity);
  }

  /*
   * @param	event UnAssignTgFromWindGenTurbineType3bIECEvent
   */
  @EventHandler(payloadType = UnAssignTgFromWindGenTurbineType3bIECEvent.class)
  public void handle(UnAssignTgFromWindGenTurbineType3bIECEvent event) {
    LOGGER.info("handling UnAssignTgFromWindGenTurbineType3bIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindGenTurbineType3bIEC entity = unAssignTg(event.getWindGenTurbineType3bIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenTurbineType3bIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenTurbineType3bIEC(entity);
  }

  /*
   * @param	event AssignTwoToWindGenTurbineType3bIECEvent
   */
  @EventHandler(payloadType = AssignTwoToWindGenTurbineType3bIECEvent.class)
  public void handle(AssignTwoToWindGenTurbineType3bIECEvent event) {
    LOGGER.info("handling AssignTwoToWindGenTurbineType3bIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindGenTurbineType3bIEC entity =
        assignTwo(event.getWindGenTurbineType3bIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenTurbineType3bIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenTurbineType3bIEC(entity);
  }

  /*
   * @param	event UnAssignTwoFromWindGenTurbineType3bIECEvent
   */
  @EventHandler(payloadType = UnAssignTwoFromWindGenTurbineType3bIECEvent.class)
  public void handle(UnAssignTwoFromWindGenTurbineType3bIECEvent event) {
    LOGGER.info("handling UnAssignTwoFromWindGenTurbineType3bIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindGenTurbineType3bIEC entity = unAssignTwo(event.getWindGenTurbineType3bIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenTurbineType3bIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenTurbineType3bIEC(entity);
  }

  /*
   * @param	event AssignXsToWindGenTurbineType3bIECEvent
   */
  @EventHandler(payloadType = AssignXsToWindGenTurbineType3bIECEvent.class)
  public void handle(AssignXsToWindGenTurbineType3bIECEvent event) {
    LOGGER.info("handling AssignXsToWindGenTurbineType3bIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindGenTurbineType3bIEC entity =
        assignXs(event.getWindGenTurbineType3bIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenTurbineType3bIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenTurbineType3bIEC(entity);
  }

  /*
   * @param	event UnAssignXsFromWindGenTurbineType3bIECEvent
   */
  @EventHandler(payloadType = UnAssignXsFromWindGenTurbineType3bIECEvent.class)
  public void handle(UnAssignXsFromWindGenTurbineType3bIECEvent event) {
    LOGGER.info("handling UnAssignXsFromWindGenTurbineType3bIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindGenTurbineType3bIEC entity = unAssignXs(event.getWindGenTurbineType3bIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenTurbineType3bIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenTurbineType3bIEC(entity);
  }

  /**
   * Method to retrieve the WindGenTurbineType3bIEC via an WindGenTurbineType3bIECPrimaryKey.
   *
   * @param id Long
   * @return WindGenTurbineType3bIEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindGenTurbineType3bIEC handle(FindWindGenTurbineType3bIECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindGenTurbineType3bIECId());
  }

  /**
   * Method to retrieve a collection of all WindGenTurbineType3bIECs
   *
   * @param query FindAllWindGenTurbineType3bIECQuery
   * @return List<WindGenTurbineType3bIEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindGenTurbineType3bIEC> handle(FindAllWindGenTurbineType3bIECQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindGenTurbineType3bIEC, but only if the id matches
   *
   * @param entity WindGenTurbineType3bIEC
   */
  protected void emitFindWindGenTurbineType3bIEC(WindGenTurbineType3bIEC entity) {
    LOGGER.info("handling emitFindWindGenTurbineType3bIEC");

    queryUpdateEmitter.emit(
        FindWindGenTurbineType3bIECQuery.class,
        query ->
            query
                .getFilter()
                .getWindGenTurbineType3bIECId()
                .equals(entity.getWindGenTurbineType3bIECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindGenTurbineType3bIEC
   *
   * @param entity WindGenTurbineType3bIEC
   */
  protected void emitFindAllWindGenTurbineType3bIEC(WindGenTurbineType3bIEC entity) {
    LOGGER.info("handling emitFindAllWindGenTurbineType3bIEC");

    queryUpdateEmitter.emit(FindAllWindGenTurbineType3bIECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType3bIECProjector.class.getName());
}
