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
 * Projector for WindPitchContEmulIEC as outlined for the CQRS pattern. All event handling and query
 * handling related to WindPitchContEmulIEC are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by WindPitchContEmulIECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windPitchContEmulIEC")
@Component("windPitchContEmulIEC-projector")
public class WindPitchContEmulIECProjector extends WindPitchContEmulIECEntityProjector {

  // core constructor
  public WindPitchContEmulIECProjector(
      WindPitchContEmulIECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = CreateWindPitchContEmulIECEvent.class)
  public void handle(CreateWindPitchContEmulIECEvent event) {
    LOGGER.info("handling CreateWindPitchContEmulIECEvent - " + event);
    WindPitchContEmulIEC entity = new WindPitchContEmulIEC();
    entity.setWindPitchContEmulIECId(event.getWindPitchContEmulIECId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event UpdateWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = UpdateWindPitchContEmulIECEvent.class)
  public void handle(UpdateWindPitchContEmulIECEvent event) {
    LOGGER.info("handling UpdateWindPitchContEmulIECEvent - " + event);

    WindPitchContEmulIEC entity = new WindPitchContEmulIEC();
    entity.setWindPitchContEmulIECId(event.getWindPitchContEmulIECId());
    entity.setKdroop(event.getKdroop());
    entity.setKipce(event.getKipce());
    entity.setKomegaaero(event.getKomegaaero());
    entity.setKppce(event.getKppce());
    entity.setOmegaref(event.getOmegaref());
    entity.setPimax(event.getPimax());
    entity.setPimin(event.getPimin());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setTpe(event.getTpe());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event DeleteWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = DeleteWindPitchContEmulIECEvent.class)
  public void handle(DeleteWindPitchContEmulIECEvent event) {
    LOGGER.info("handling DeleteWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindPitchContEmulIEC entity = delete(event.getWindPitchContEmulIECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event AssignKdroopToWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = AssignKdroopToWindPitchContEmulIECEvent.class)
  public void handle(AssignKdroopToWindPitchContEmulIECEvent event) {
    LOGGER.info("handling AssignKdroopToWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPitchContEmulIEC entity =
        assignKdroop(event.getWindPitchContEmulIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event UnAssignKdroopFromWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = UnAssignKdroopFromWindPitchContEmulIECEvent.class)
  public void handle(UnAssignKdroopFromWindPitchContEmulIECEvent event) {
    LOGGER.info("handling UnAssignKdroopFromWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPitchContEmulIEC entity = unAssignKdroop(event.getWindPitchContEmulIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event AssignKipceToWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = AssignKipceToWindPitchContEmulIECEvent.class)
  public void handle(AssignKipceToWindPitchContEmulIECEvent event) {
    LOGGER.info("handling AssignKipceToWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPitchContEmulIEC entity =
        assignKipce(event.getWindPitchContEmulIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event UnAssignKipceFromWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = UnAssignKipceFromWindPitchContEmulIECEvent.class)
  public void handle(UnAssignKipceFromWindPitchContEmulIECEvent event) {
    LOGGER.info("handling UnAssignKipceFromWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPitchContEmulIEC entity = unAssignKipce(event.getWindPitchContEmulIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event AssignKomegaaeroToWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = AssignKomegaaeroToWindPitchContEmulIECEvent.class)
  public void handle(AssignKomegaaeroToWindPitchContEmulIECEvent event) {
    LOGGER.info("handling AssignKomegaaeroToWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPitchContEmulIEC entity =
        assignKomegaaero(event.getWindPitchContEmulIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event UnAssignKomegaaeroFromWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = UnAssignKomegaaeroFromWindPitchContEmulIECEvent.class)
  public void handle(UnAssignKomegaaeroFromWindPitchContEmulIECEvent event) {
    LOGGER.info("handling UnAssignKomegaaeroFromWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPitchContEmulIEC entity = unAssignKomegaaero(event.getWindPitchContEmulIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event AssignKppceToWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = AssignKppceToWindPitchContEmulIECEvent.class)
  public void handle(AssignKppceToWindPitchContEmulIECEvent event) {
    LOGGER.info("handling AssignKppceToWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPitchContEmulIEC entity =
        assignKppce(event.getWindPitchContEmulIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event UnAssignKppceFromWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = UnAssignKppceFromWindPitchContEmulIECEvent.class)
  public void handle(UnAssignKppceFromWindPitchContEmulIECEvent event) {
    LOGGER.info("handling UnAssignKppceFromWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPitchContEmulIEC entity = unAssignKppce(event.getWindPitchContEmulIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event AssignOmegarefToWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = AssignOmegarefToWindPitchContEmulIECEvent.class)
  public void handle(AssignOmegarefToWindPitchContEmulIECEvent event) {
    LOGGER.info("handling AssignOmegarefToWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPitchContEmulIEC entity =
        assignOmegaref(event.getWindPitchContEmulIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event UnAssignOmegarefFromWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = UnAssignOmegarefFromWindPitchContEmulIECEvent.class)
  public void handle(UnAssignOmegarefFromWindPitchContEmulIECEvent event) {
    LOGGER.info("handling UnAssignOmegarefFromWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPitchContEmulIEC entity = unAssignOmegaref(event.getWindPitchContEmulIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event AssignPimaxToWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = AssignPimaxToWindPitchContEmulIECEvent.class)
  public void handle(AssignPimaxToWindPitchContEmulIECEvent event) {
    LOGGER.info("handling AssignPimaxToWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPitchContEmulIEC entity =
        assignPimax(event.getWindPitchContEmulIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event UnAssignPimaxFromWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = UnAssignPimaxFromWindPitchContEmulIECEvent.class)
  public void handle(UnAssignPimaxFromWindPitchContEmulIECEvent event) {
    LOGGER.info("handling UnAssignPimaxFromWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPitchContEmulIEC entity = unAssignPimax(event.getWindPitchContEmulIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event AssignPiminToWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = AssignPiminToWindPitchContEmulIECEvent.class)
  public void handle(AssignPiminToWindPitchContEmulIECEvent event) {
    LOGGER.info("handling AssignPiminToWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPitchContEmulIEC entity =
        assignPimin(event.getWindPitchContEmulIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event UnAssignPiminFromWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = UnAssignPiminFromWindPitchContEmulIECEvent.class)
  public void handle(UnAssignPiminFromWindPitchContEmulIECEvent event) {
    LOGGER.info("handling UnAssignPiminFromWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPitchContEmulIEC entity = unAssignPimin(event.getWindPitchContEmulIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event AssignT1ToWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = AssignT1ToWindPitchContEmulIECEvent.class)
  public void handle(AssignT1ToWindPitchContEmulIECEvent event) {
    LOGGER.info("handling AssignT1ToWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPitchContEmulIEC entity =
        assignT1(event.getWindPitchContEmulIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event UnAssignT1FromWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = UnAssignT1FromWindPitchContEmulIECEvent.class)
  public void handle(UnAssignT1FromWindPitchContEmulIECEvent event) {
    LOGGER.info("handling UnAssignT1FromWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPitchContEmulIEC entity = unAssignT1(event.getWindPitchContEmulIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event AssignT2ToWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = AssignT2ToWindPitchContEmulIECEvent.class)
  public void handle(AssignT2ToWindPitchContEmulIECEvent event) {
    LOGGER.info("handling AssignT2ToWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPitchContEmulIEC entity =
        assignT2(event.getWindPitchContEmulIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event UnAssignT2FromWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = UnAssignT2FromWindPitchContEmulIECEvent.class)
  public void handle(UnAssignT2FromWindPitchContEmulIECEvent event) {
    LOGGER.info("handling UnAssignT2FromWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPitchContEmulIEC entity = unAssignT2(event.getWindPitchContEmulIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event AssignTpeToWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = AssignTpeToWindPitchContEmulIECEvent.class)
  public void handle(AssignTpeToWindPitchContEmulIECEvent event) {
    LOGGER.info("handling AssignTpeToWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPitchContEmulIEC entity =
        assignTpe(event.getWindPitchContEmulIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /*
   * @param	event UnAssignTpeFromWindPitchContEmulIECEvent
   */
  @EventHandler(payloadType = UnAssignTpeFromWindPitchContEmulIECEvent.class)
  public void handle(UnAssignTpeFromWindPitchContEmulIECEvent event) {
    LOGGER.info("handling UnAssignTpeFromWindPitchContEmulIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPitchContEmulIEC entity = unAssignTpe(event.getWindPitchContEmulIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPitchContEmulIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPitchContEmulIEC(entity);
  }

  /**
   * Method to retrieve the WindPitchContEmulIEC via an WindPitchContEmulIECPrimaryKey.
   *
   * @param id Long
   * @return WindPitchContEmulIEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindPitchContEmulIEC handle(FindWindPitchContEmulIECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindPitchContEmulIECId());
  }

  /**
   * Method to retrieve a collection of all WindPitchContEmulIECs
   *
   * @param query FindAllWindPitchContEmulIECQuery
   * @return List<WindPitchContEmulIEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindPitchContEmulIEC> handle(FindAllWindPitchContEmulIECQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindPitchContEmulIEC, but only if the id matches
   *
   * @param entity WindPitchContEmulIEC
   */
  protected void emitFindWindPitchContEmulIEC(WindPitchContEmulIEC entity) {
    LOGGER.info("handling emitFindWindPitchContEmulIEC");

    queryUpdateEmitter.emit(
        FindWindPitchContEmulIECQuery.class,
        query ->
            query
                .getFilter()
                .getWindPitchContEmulIECId()
                .equals(entity.getWindPitchContEmulIECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindPitchContEmulIEC
   *
   * @param entity WindPitchContEmulIEC
   */
  protected void emitFindAllWindPitchContEmulIEC(WindPitchContEmulIEC entity) {
    LOGGER.info("handling emitFindAllWindPitchContEmulIEC");

    queryUpdateEmitter.emit(FindAllWindPitchContEmulIECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(WindPitchContEmulIECProjector.class.getName());
}
