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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.validator.*;
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
 * Simple_Float business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Simple_Float related services in the case of a Simple_Float
 *       business related service failing.
 *   <li>Exposes a simpler, uniform Simple_Float interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Simple_Float business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class Simple_FloatBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public Simple_FloatBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Simple_Float Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return Simple_FloatBusinessDelegate
   */
  public static Simple_FloatBusinessDelegate getSimple_FloatInstance() {
    return (new Simple_FloatBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSimple_Float(CreateSimple_FloatCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSimple_FloatId() == null) command.setSimple_FloatId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      Simple_FloatValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSimple_FloatCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSimple_FloatCommand of Simple_Float is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Simple_Float - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSimple_FloatCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSimple_Float(UpdateSimple_FloatCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      Simple_FloatValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSimple_FloatCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Simple_Float - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSimple_FloatCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSimple_FloatCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Simple_FloatValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSimple_FloatCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete Simple_Float using Id = " + command.getSimple_FloatId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Simple_Float via Simple_FloatFetchOneSummary
   *
   * @param summary Simple_FloatFetchOneSummary
   * @return Simple_FloatFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Simple_Float getSimple_Float(Simple_FloatFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("Simple_FloatFetchOneSummary arg cannot be null");

    Simple_Float entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      Simple_FloatValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Simple_Float
      // --------------------------------------
      CompletableFuture<Simple_Float> futureEntity =
          queryGateway.query(
              new FindSimple_FloatQuery(new LoadSimple_FloatFilter(summary.getSimple_FloatId())),
              ResponseTypes.instanceOf(Simple_Float.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Simple_Float with id " + summary.getSimple_FloatId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Simple_Floats
   *
   * @return List<Simple_Float>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Simple_Float> getAllSimple_Float() throws ProcessingException {
    List<Simple_Float> list = null;

    try {
      CompletableFuture<List<Simple_Float>> futureList =
          queryGateway.query(
              new FindAllSimple_FloatQuery(),
              ResponseTypes.multipleInstancesOf(Simple_Float.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Simple_Float";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on Simple_Float
   *
   * @param command AssignValueToSimple_FloatCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToSimple_FloatCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSimple_FloatId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FloatProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FloatProxyBusinessDelegate.getFloatProxyInstance();
    Simple_FloatBusinessDelegate parentDelegate =
        Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    UUID childId = command.getAssignment().getFloatProxyId();
    FloatProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Simple_FloatValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get FloatProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Value on Simple_Float
   *
   * @param command UnAssignValueFromSimple_FloatCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromSimple_FloatCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Simple_FloatValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on Simple_Float";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Simple_Float
   */
  private Simple_Float load(UUID id) throws ProcessingException {
    simple_Float =
        Simple_FloatBusinessDelegate.getSimple_FloatInstance()
            .getSimple_Float(new Simple_FloatFetchOneSummary(id));
    return simple_Float;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Simple_Float simple_Float = null;
  private static final Logger LOGGER =
      Logger.getLogger(Simple_FloatBusinessDelegate.class.getName());
}
