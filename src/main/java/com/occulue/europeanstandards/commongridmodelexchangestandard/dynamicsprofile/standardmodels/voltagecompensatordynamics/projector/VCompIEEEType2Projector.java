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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for VCompIEEEType2 as outlined for the CQRS pattern. All event handling and query
 * handling related to VCompIEEEType2 are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by VCompIEEEType2Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("vCompIEEEType2")
@Component("vCompIEEEType2-projector")
public class VCompIEEEType2Projector extends VCompIEEEType2EntityProjector {

  // core constructor
  public VCompIEEEType2Projector(
      VCompIEEEType2Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateVCompIEEEType2Event
   */
  @EventHandler(payloadType = CreateVCompIEEEType2Event.class)
  public void handle(CreateVCompIEEEType2Event event) {
    LOGGER.info("handling CreateVCompIEEEType2Event - " + event);
    VCompIEEEType2 entity = new VCompIEEEType2();
    entity.setVCompIEEEType2Id(event.getVCompIEEEType2Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVCompIEEEType2(entity);
  }

  /*
   * @param	event UpdateVCompIEEEType2Event
   */
  @EventHandler(payloadType = UpdateVCompIEEEType2Event.class)
  public void handle(UpdateVCompIEEEType2Event event) {
    LOGGER.info("handling UpdateVCompIEEEType2Event - " + event);

    VCompIEEEType2 entity = new VCompIEEEType2();
    entity.setVCompIEEEType2Id(event.getVCompIEEEType2Id());
    entity.setTr(event.getTr());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVCompIEEEType2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVCompIEEEType2(entity);
  }

  /*
   * @param	event DeleteVCompIEEEType2Event
   */
  @EventHandler(payloadType = DeleteVCompIEEEType2Event.class)
  public void handle(DeleteVCompIEEEType2Event event) {
    LOGGER.info("handling DeleteVCompIEEEType2Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    VCompIEEEType2 entity = delete(event.getVCompIEEEType2Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVCompIEEEType2(entity);
  }

  /*
   * @param	event AssignTrToVCompIEEEType2Event
   */
  @EventHandler(payloadType = AssignTrToVCompIEEEType2Event.class)
  public void handle(AssignTrToVCompIEEEType2Event event) {
    LOGGER.info("handling AssignTrToVCompIEEEType2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    VCompIEEEType2 entity = assignTr(event.getVCompIEEEType2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVCompIEEEType2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVCompIEEEType2(entity);
  }

  /*
   * @param	event UnAssignTrFromVCompIEEEType2Event
   */
  @EventHandler(payloadType = UnAssignTrFromVCompIEEEType2Event.class)
  public void handle(UnAssignTrFromVCompIEEEType2Event event) {
    LOGGER.info("handling UnAssignTrFromVCompIEEEType2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    VCompIEEEType2 entity = unAssignTr(event.getVCompIEEEType2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVCompIEEEType2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVCompIEEEType2(entity);
  }

  /**
   * Method to retrieve the VCompIEEEType2 via an VCompIEEEType2PrimaryKey.
   *
   * @param id Long
   * @return VCompIEEEType2
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public VCompIEEEType2 handle(FindVCompIEEEType2Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getVCompIEEEType2Id());
  }

  /**
   * Method to retrieve a collection of all VCompIEEEType2s
   *
   * @param query FindAllVCompIEEEType2Query
   * @return List<VCompIEEEType2>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<VCompIEEEType2> handle(FindAllVCompIEEEType2Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindVCompIEEEType2, but only if the id matches
   *
   * @param entity VCompIEEEType2
   */
  protected void emitFindVCompIEEEType2(VCompIEEEType2 entity) {
    LOGGER.info("handling emitFindVCompIEEEType2");

    queryUpdateEmitter.emit(
        FindVCompIEEEType2Query.class,
        query -> query.getFilter().getVCompIEEEType2Id().equals(entity.getVCompIEEEType2Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllVCompIEEEType2
   *
   * @param entity VCompIEEEType2
   */
  protected void emitFindAllVCompIEEEType2(VCompIEEEType2 entity) {
    LOGGER.info("handling emitFindAllVCompIEEEType2");

    queryUpdateEmitter.emit(FindAllVCompIEEEType2Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(VCompIEEEType2Projector.class.getName());
}
