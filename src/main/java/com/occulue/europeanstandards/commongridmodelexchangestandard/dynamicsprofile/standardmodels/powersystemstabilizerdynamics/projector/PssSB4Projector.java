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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PssSB4 as outlined for the CQRS pattern. All event handling and query handling
 * related to PssSB4 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by PssSB4Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pssSB4")
@Component("pssSB4-projector")
public class PssSB4Projector extends PssSB4EntityProjector {

  // core constructor
  public PssSB4Projector(PssSB4Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePssSB4Event
   */
  @EventHandler(payloadType = CreatePssSB4Event.class)
  public void handle(CreatePssSB4Event event) {
    LOGGER.info("handling CreatePssSB4Event - " + event);
    PssSB4 entity = new PssSB4();
    entity.setPssSB4Id(event.getPssSB4Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event UpdatePssSB4Event
   */
  @EventHandler(payloadType = UpdatePssSB4Event.class)
  public void handle(UpdatePssSB4Event event) {
    LOGGER.info("handling UpdatePssSB4Event - " + event);

    PssSB4 entity = new PssSB4();
    entity.setPssSB4Id(event.getPssSB4Id());
    entity.setKx(event.getKx());
    entity.setTa(event.getTa());
    entity.setTb(event.getTb());
    entity.setTc(event.getTc());
    entity.setTd(event.getTd());
    entity.setTe(event.getTe());
    entity.setTt(event.getTt());
    entity.setTx1(event.getTx1());
    entity.setTx2(event.getTx2());
    entity.setVsmax(event.getVsmax());
    entity.setVsmin(event.getVsmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event DeletePssSB4Event
   */
  @EventHandler(payloadType = DeletePssSB4Event.class)
  public void handle(DeletePssSB4Event event) {
    LOGGER.info("handling DeletePssSB4Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PssSB4 entity = delete(event.getPssSB4Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event AssignKxToPssSB4Event
   */
  @EventHandler(payloadType = AssignKxToPssSB4Event.class)
  public void handle(AssignKxToPssSB4Event event) {
    LOGGER.info("handling AssignKxToPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSB4 entity = assignKx(event.getPssSB4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event UnAssignKxFromPssSB4Event
   */
  @EventHandler(payloadType = UnAssignKxFromPssSB4Event.class)
  public void handle(UnAssignKxFromPssSB4Event event) {
    LOGGER.info("handling UnAssignKxFromPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSB4 entity = unAssignKx(event.getPssSB4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event AssignTaToPssSB4Event
   */
  @EventHandler(payloadType = AssignTaToPssSB4Event.class)
  public void handle(AssignTaToPssSB4Event event) {
    LOGGER.info("handling AssignTaToPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSB4 entity = assignTa(event.getPssSB4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event UnAssignTaFromPssSB4Event
   */
  @EventHandler(payloadType = UnAssignTaFromPssSB4Event.class)
  public void handle(UnAssignTaFromPssSB4Event event) {
    LOGGER.info("handling UnAssignTaFromPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSB4 entity = unAssignTa(event.getPssSB4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event AssignTbToPssSB4Event
   */
  @EventHandler(payloadType = AssignTbToPssSB4Event.class)
  public void handle(AssignTbToPssSB4Event event) {
    LOGGER.info("handling AssignTbToPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSB4 entity = assignTb(event.getPssSB4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event UnAssignTbFromPssSB4Event
   */
  @EventHandler(payloadType = UnAssignTbFromPssSB4Event.class)
  public void handle(UnAssignTbFromPssSB4Event event) {
    LOGGER.info("handling UnAssignTbFromPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSB4 entity = unAssignTb(event.getPssSB4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event AssignTcToPssSB4Event
   */
  @EventHandler(payloadType = AssignTcToPssSB4Event.class)
  public void handle(AssignTcToPssSB4Event event) {
    LOGGER.info("handling AssignTcToPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSB4 entity = assignTc(event.getPssSB4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event UnAssignTcFromPssSB4Event
   */
  @EventHandler(payloadType = UnAssignTcFromPssSB4Event.class)
  public void handle(UnAssignTcFromPssSB4Event event) {
    LOGGER.info("handling UnAssignTcFromPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSB4 entity = unAssignTc(event.getPssSB4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event AssignTdToPssSB4Event
   */
  @EventHandler(payloadType = AssignTdToPssSB4Event.class)
  public void handle(AssignTdToPssSB4Event event) {
    LOGGER.info("handling AssignTdToPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSB4 entity = assignTd(event.getPssSB4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event UnAssignTdFromPssSB4Event
   */
  @EventHandler(payloadType = UnAssignTdFromPssSB4Event.class)
  public void handle(UnAssignTdFromPssSB4Event event) {
    LOGGER.info("handling UnAssignTdFromPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSB4 entity = unAssignTd(event.getPssSB4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event AssignTeToPssSB4Event
   */
  @EventHandler(payloadType = AssignTeToPssSB4Event.class)
  public void handle(AssignTeToPssSB4Event event) {
    LOGGER.info("handling AssignTeToPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSB4 entity = assignTe(event.getPssSB4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event UnAssignTeFromPssSB4Event
   */
  @EventHandler(payloadType = UnAssignTeFromPssSB4Event.class)
  public void handle(UnAssignTeFromPssSB4Event event) {
    LOGGER.info("handling UnAssignTeFromPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSB4 entity = unAssignTe(event.getPssSB4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event AssignTtToPssSB4Event
   */
  @EventHandler(payloadType = AssignTtToPssSB4Event.class)
  public void handle(AssignTtToPssSB4Event event) {
    LOGGER.info("handling AssignTtToPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSB4 entity = assignTt(event.getPssSB4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event UnAssignTtFromPssSB4Event
   */
  @EventHandler(payloadType = UnAssignTtFromPssSB4Event.class)
  public void handle(UnAssignTtFromPssSB4Event event) {
    LOGGER.info("handling UnAssignTtFromPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSB4 entity = unAssignTt(event.getPssSB4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event AssignTx1ToPssSB4Event
   */
  @EventHandler(payloadType = AssignTx1ToPssSB4Event.class)
  public void handle(AssignTx1ToPssSB4Event event) {
    LOGGER.info("handling AssignTx1ToPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSB4 entity = assignTx1(event.getPssSB4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event UnAssignTx1FromPssSB4Event
   */
  @EventHandler(payloadType = UnAssignTx1FromPssSB4Event.class)
  public void handle(UnAssignTx1FromPssSB4Event event) {
    LOGGER.info("handling UnAssignTx1FromPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSB4 entity = unAssignTx1(event.getPssSB4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event AssignTx2ToPssSB4Event
   */
  @EventHandler(payloadType = AssignTx2ToPssSB4Event.class)
  public void handle(AssignTx2ToPssSB4Event event) {
    LOGGER.info("handling AssignTx2ToPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSB4 entity = assignTx2(event.getPssSB4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event UnAssignTx2FromPssSB4Event
   */
  @EventHandler(payloadType = UnAssignTx2FromPssSB4Event.class)
  public void handle(UnAssignTx2FromPssSB4Event event) {
    LOGGER.info("handling UnAssignTx2FromPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSB4 entity = unAssignTx2(event.getPssSB4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event AssignVsmaxToPssSB4Event
   */
  @EventHandler(payloadType = AssignVsmaxToPssSB4Event.class)
  public void handle(AssignVsmaxToPssSB4Event event) {
    LOGGER.info("handling AssignVsmaxToPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSB4 entity = assignVsmax(event.getPssSB4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event UnAssignVsmaxFromPssSB4Event
   */
  @EventHandler(payloadType = UnAssignVsmaxFromPssSB4Event.class)
  public void handle(UnAssignVsmaxFromPssSB4Event event) {
    LOGGER.info("handling UnAssignVsmaxFromPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSB4 entity = unAssignVsmax(event.getPssSB4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event AssignVsminToPssSB4Event
   */
  @EventHandler(payloadType = AssignVsminToPssSB4Event.class)
  public void handle(AssignVsminToPssSB4Event event) {
    LOGGER.info("handling AssignVsminToPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSB4 entity = assignVsmin(event.getPssSB4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /*
   * @param	event UnAssignVsminFromPssSB4Event
   */
  @EventHandler(payloadType = UnAssignVsminFromPssSB4Event.class)
  public void handle(UnAssignVsminFromPssSB4Event event) {
    LOGGER.info("handling UnAssignVsminFromPssSB4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSB4 entity = unAssignVsmin(event.getPssSB4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSB4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSB4(entity);
  }

  /**
   * Method to retrieve the PssSB4 via an PssSB4PrimaryKey.
   *
   * @param id Long
   * @return PssSB4
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PssSB4 handle(FindPssSB4Query query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPssSB4Id());
  }

  /**
   * Method to retrieve a collection of all PssSB4s
   *
   * @param query FindAllPssSB4Query
   * @return List<PssSB4>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PssSB4> handle(FindAllPssSB4Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPssSB4, but only if the id matches
   *
   * @param entity PssSB4
   */
  protected void emitFindPssSB4(PssSB4 entity) {
    LOGGER.info("handling emitFindPssSB4");

    queryUpdateEmitter.emit(
        FindPssSB4Query.class,
        query -> query.getFilter().getPssSB4Id().equals(entity.getPssSB4Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPssSB4
   *
   * @param entity PssSB4
   */
  protected void emitFindAllPssSB4(PssSB4 entity) {
    LOGGER.info("handling emitFindAllPssSB4");

    queryUpdateEmitter.emit(FindAllPssSB4Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PssSB4Projector.class.getName());
}
