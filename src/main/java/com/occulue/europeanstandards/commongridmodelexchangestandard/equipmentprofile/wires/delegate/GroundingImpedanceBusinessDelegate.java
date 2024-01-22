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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * GroundingImpedance business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of GroundingImpedance related services in the case of a
 *       GroundingImpedance business related service failing.
 *   <li>Exposes a simpler, uniform GroundingImpedance interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill GroundingImpedance
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class GroundingImpedanceBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public GroundingImpedanceBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * GroundingImpedance Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return GroundingImpedanceBusinessDelegate
   */
  public static GroundingImpedanceBusinessDelegate getGroundingImpedanceInstance() {
    return (new GroundingImpedanceBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createGroundingImpedance(CreateGroundingImpedanceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getGroundingImpedanceId() == null)
        command.setGroundingImpedanceId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      GroundingImpedanceValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateGroundingImpedanceCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateGroundingImpedanceCommand of GroundingImpedance is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create GroundingImpedance - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateGroundingImpedanceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateGroundingImpedance(UpdateGroundingImpedanceCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      GroundingImpedanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateGroundingImpedanceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save GroundingImpedance - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteGroundingImpedanceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteGroundingImpedanceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GroundingImpedanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteGroundingImpedanceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete GroundingImpedance using Id = " + command.getGroundingImpedanceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the GroundingImpedance via GroundingImpedanceFetchOneSummary
   *
   * @param summary GroundingImpedanceFetchOneSummary
   * @return GroundingImpedanceFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public GroundingImpedance getGroundingImpedance(GroundingImpedanceFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("GroundingImpedanceFetchOneSummary arg cannot be null");

    GroundingImpedance entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      GroundingImpedanceValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a GroundingImpedance
      // --------------------------------------
      CompletableFuture<GroundingImpedance> futureEntity =
          queryGateway.query(
              new FindGroundingImpedanceQuery(
                  new LoadGroundingImpedanceFilter(summary.getGroundingImpedanceId())),
              ResponseTypes.instanceOf(GroundingImpedance.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate GroundingImpedance with id " + summary.getGroundingImpedanceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all GroundingImpedances
   *
   * @return List<GroundingImpedance>
   * @exception ProcessingException Thrown if any problems
   */
  public List<GroundingImpedance> getAllGroundingImpedance() throws ProcessingException {
    List<GroundingImpedance> list = null;

    try {
      CompletableFuture<List<GroundingImpedance>> futureList =
          queryGateway.query(
              new FindAllGroundingImpedanceQuery(),
              ResponseTypes.multipleInstancesOf(GroundingImpedance.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all GroundingImpedance";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign X on GroundingImpedance
   *
   * @param command AssignXToGroundingImpedanceCommand
   * @exception ProcessingException
   */
  public void assignX(AssignXToGroundingImpedanceCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGroundingImpedanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    GroundingImpedanceBusinessDelegate parentDelegate =
        GroundingImpedanceBusinessDelegate.getGroundingImpedanceInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GroundingImpedanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Reactance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign X on GroundingImpedance
   *
   * @param command UnAssignXFromGroundingImpedanceCommand
   * @exception ProcessingException
   */
  public void unAssignX(UnAssignXFromGroundingImpedanceCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GroundingImpedanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X on GroundingImpedance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return GroundingImpedance
   */
  private GroundingImpedance load(UUID id) throws ProcessingException {
    groundingImpedance =
        GroundingImpedanceBusinessDelegate.getGroundingImpedanceInstance()
            .getGroundingImpedance(new GroundingImpedanceFetchOneSummary(id));
    return groundingImpedance;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private GroundingImpedance groundingImpedance = null;
  private static final Logger LOGGER =
      Logger.getLogger(GroundingImpedanceBusinessDelegate.class.getName());
}
